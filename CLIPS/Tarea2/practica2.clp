; USER STUCTURE
(deftemplate user
	(slot name (type STRING))
	(multislot languages)
	(multislot trip-type)
	(slot max-cost (type NUMBER) (range 1 5))
)

; DESTINATION STUCTURE
(deftemplate destination
	(slot name (type STRING))
	(multislot countries)
	(multislot attractions)
)

; COUNTRY STUCTURE
(deftemplate country
	(slot name (type STRING))
	(multislot languages (default English))
	(slot cost (type NUMBER) (range 1 5) (default 4))
)


; STAGE RESULT
(deftemplate first-stage
    (slot user (type STRING))
    (slot destination)
    (slot country)
)

(deftemplate second-stage
    (slot user (type STRING))
    (slot destination)
    (slot country)
)

(deftemplate third-stage
    (slot user (type STRING))
    (slot destination)
    (slot country)
    (slot like-match (type NUMBER) (default 0))
)


; USER ASSERTIONS
(deffacts users-db

	;(user (name "Bartolo") (max-cost 1) (languages French) (trip-type Landscaping ))
	;(user (name "Rockerfeller") (max-cost 5) (languages English) (trip-type Entertainment Landscaping Cultural))
	(user (name "Babel") (max-cost 3) (languages Spanish English Japanese Chinese Basque German) (trip-type Cultural Landscaping))
)


; DESTINATION ASSERTIONS
(deffacts destinations-db	
	
	(destination (name "Pyrenees") (countries "Spain" "France") (attractions Landscaping Entertainment))
	(destination (name "Wrecked Castles") (countries "Germany" "Poland") (attractions Cultural))
	(destination (name "Mount Fuji") (countries "Japan") (attractions Landscaping Entertainment Cultural))
	(destination (name "Hochosterwitz Castle") (countries "Austria") (attractions Landscaping Cultural))
	(destination (name "Las Vegas") (countries "United States") (attractions Entertainment))
)


; COUNTRY ASSERTIONS
(deffacts countries-db	
	
	(country (name "France") (languages English French))
	(country (name "Spain") (languages English Spanish Catalan Basque Galician) (cost 1))
	(country (name "Japan") (languages English Japanese Chinese) (cost 5))
	(country (name "Poland") (languages English Polish) (cost 2))
	(country (name "Germany") (languages English German))
	(country (name "Austria") (languages English German French) (cost 3))
	(country (name "United States") (cost 4))
)


; FUNCTION DEFINITION
(deffunction interseccion (?a ?b)
	(bind ?r (create$))
	(foreach ?e ?a
		(if (and (member$ ?e ?b) (not (member$ ?e ?r)))
			then (bind ?r (create$ ?r ?e))
		)
	)
	(return ?r)
)


; RULE DEFINITION

; FIRST STAGE
(defrule dest-financial-selector
    (declare (salience 100))
    
    (country (name ?country-name) (cost ?cost))
    
    (user 
        (name ?user)
        (max-cost ?max-cost&:(>= ?max-cost ?cost))
    )
    
    (destination
        (name ?dest-name)
        (countries $?dest-country&:(member$ ?country-name $?dest-country))
    )
    
    =>
    
    (assert (first-stage (user ?user) (destination ?dest-name) (country ?country-name)))
)

; SECOND STAGE
(defrule dest-lang-selector
    (declare (salience 66))
    
    ?fact-first-stage<-(first-stage (user ?user) (destination ?dest-name) (country ?country-name))
    
    (user 
        (name ?user)
        (languages $? ?user-lang $?)
    )
    
    (country
        (name ?country-name)
        (languages $?country-langs&:(member$ ?user-lang $?country-langs))
    )
    
    =>
    
    (assert (second-stage (user ?user) (destination ?dest-name) (country ?country-name)))
    (retract ?fact-first-stage)
)

; THIRD STAGE
(defrule like-match-selector
    (declare (salience 33))
    
    ?fact-second-stage<-(second-stage (user ?user) (destination ?dest-name) (country ?country-name))
    
    (destination
        (name ?dest-name)
        (attractions $?dest-attr)
    )
    
    (user
        (name ?user)
        (trip-type $?user-attr)
    )
    
    =>
    
    (assert 
        (third-stage 
            (user ?user)
            (destination ?dest-name) 
            (country ?country-name) 
            (like-match 
                (length$ (interseccion $?dest-attr $?user-attr))
            )
        )
    )
    
    (retract ?fact-second-stage)
)

(defrule show-result
    (third-stage 
        (user ?user)
        (destination ?dest-name) 
        (country ?country-name) 
        (like-match ?like-match-1)
    )
    
    (not (third-stage
        (like-match ?like-match-2&:(> ?like-match-2 ?like-match-1))
    ))
    
    =>
    
    (printout t ?user " ==> " ?dest-name " (" ?country-name ") ==> " ?like-match-1 " like-match points" crlf)
)
