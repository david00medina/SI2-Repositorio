;;; Conceptos
(deftemplate book
  "Book data"
  (slot id (type INTEGER))
  (slot name (type STRING))
  (slot year (type INTEGER))
  (slot category (type STRING))
)

(deftemplate bookshelf
  "Bookshelf information"
  (slot id (type INTEGER))
  (multislot books (type INTEGER))
  (slot category (type STRING))
  (slot capacity (type INTEGER) (default 3))
)

(deffacts initialize-concepts
  (book (id 1) (name "Cien Anyos de Soledad") (year 1967) (category "Novel"))
  (book (id 2) (name "Los Pilares de la Tierra") (year 1989) (category "Novel"))
  (book (id 3) (name "Yo Robot") (year 1950) (category "Novel"))
  (book (id 4) (name "La Maleta") (year 1982) (category "Poetry"))
  (book (id 5) (name "En las Orillas del Sar") (year 1884) (category "Poetry"))
  (book (id 6) (name "Expert Systems: Principles and Programming") (year 2004) (category "Manual"))
  (book (id 7) (name "Tecnologias de la web semantica") (year 2011) (category "Manual"))
  
  (bookshelf (id 1) (category "Novel")) 
  (bookshelf (id 2) (category "Poetry")) 
  (bookshelf (id 3) (category "Manual"))
)


;;;;
;;;; hechos
;;;;

(deffacts datos
; numero de variables del problema
  (estructura 3)

  ; dominios para cada variable
  (dominio 1 1 2 3) 
  (dominio 2 1 2 3) 
  (dominio 3 1 2 3)
  (dominio 4 1 2 3)
  (dominio 5 1 2 3)
  (dominio 6 1 2 3)
  (dominio 7 1 2 3)
  
;solucion
	(solucion))

;(deffacts informacion-control
;	(secuencia-fases avances restricciones))

; contador de soluciones encontradas
(defglobal ?*nsol* = 0) 

(deftemplate elementos ;Hay tantos elementos como numeros de variables (a-g) existen por cada dominio (1-7)
	(slot posicion ;Indica el dominio al que pertenece
		(default 0)
		(type INTEGER))
	(slot elemento ;Valor en concreto (a-g)
		(type INTEGER))
	(slot eliminado ;Averigua si ya hemos bajado por esa rama
		(default 0)
		(type INTEGER)))

;;;;
;;;; reglas
;;;;

(defrule inicio
	(declare (salience 10000))
	=>
	(assert (fase inicializacion)))
	
;;;; reglas inicializacion
(defrule genera-elemento-dominio
	(fase inicializacion)
	(dominio ?pos $? ?ele $?)
	=>
	(assert (elementos
				(posicion ?pos)
				(elemento ?ele)
				(eliminado 0))))
				
(defrule cambio-fase ;Hacemos una regla con una prioridad menor para que no se ejecute hasta que todas las demas se ejecuten
	(declare (salience -10))
	?f <- (fase inicializacion)
	=>
	(retract ?f)
	(assert (fase avance)))

	
;;;; reglas avance
(defrule avanza
	(declare (salience 100))
	(fase avance)	
	?f <- (solucion $?a)
; quedan elementos para añadir en la siguiente posicion de la solucion (no han sido eliminados)
	(elementos 
		(elemento ?ele) ;buscamos un elemento
		(posicion ?b&:(= ?b (+ 1 (length$ $?a)))) ; del dominio siguiente ; Busca el valor ?b de posicion cuyo valor sea +1 la longitud de ?a
		(eliminado 0)) ; que este disponible
	=>
	(retract ?f)
	(assert (solucion $?a ?ele)))

; detecta que tenemos un dominio saturado.
(defrule detecta-dominio-saturado
	(declare (salience 300))
	(fase avance)	
	(solucion $?sol)
	(elementos
		(posicion ?b&:(= ?b (+ 1 (length$ ?sol))))) ; se corresponde con el siguiente dominio 
	(not (elementos
			(posicion ?b)
			(eliminado 0))) ; que no tenga disponibles
	=>
	(assert (vuelta-atras)))

; regla que comprueba si se ha alcanzado una solución
(defrule detecta-solucion
	(declare (salience 100))
	(fase avance)	
	?f <- (solucion $?a ?b)
	(estructura ?n&:(= (- ?n 1) (length$ ?a)))
	?h <- (elementos
		(elemento ?b)
		(posicion ?pos&:(= ?pos (+ 1 (length$ ?a))))
		)
	=>
	(bind ?*nsol* (+ 1 ?*nsol*))
	(printout t "Solucion " ?*nsol* " -> " (create$ $?a ?b) crlf)
	(modify ?h (eliminado 1))
	(assert (solucion $?a))
	(retract ?f))

;La aplicación acaba cuando se detecta que tenemos el dominio 1 saturado
(defrule fin
	(declare (salience 3000))
	?f <- (fase avance)
	(not (elementos 
			(posicion 1)
			(eliminado 0))) ; que no tenga disponibles
	=>
	(retract ?f)
	(printout t "Fin: " ?*nsol* crlf))
	
; Anula el ultimo valor  de la solución y libera la condición de vuelta-atrás
(defrule fin-vuelta-atras
	(declare (salience 350))
	(fase avance)	
	?f <- (vuelta-atras)
	?g <- (solucion $?inicio ?a)
	?h <- (elementos
			(posicion ?b&:(= ?b (+ 1 (length$ ?inicio))))
			(elemento ?a))
	=>
	(modify ?h (eliminado 1))
	(assert (solucion ?inicio))
	(retract ?f ?g))
	
; restaura valores de dominios
(defrule restaura-nivel
	(declare (salience 400))
	(fase avance)	
	(vuelta-atras)
	(solucion $?s)
	?f <- (elementos
				(posicion ?b&:(= ?b (+ 1 (length$ ?s))))
				(eliminado 1))
	=>
	(modify ?f (eliminado 0)))

	
;;;;
;;;; reglas restricciones
;;;;

(defrule out-of-bound
	(declare (salience 200))
	(fase avance)	
	(not (vuelta-atras))
	
	(solucion $?inicio ?ele) 
	?f <- (elementos
			(elemento ?ele)
			(posicion ?b&:(= ?b (+ 1 (length$ $?inicio))))
	)
	(bookshelf (capacity ?capacity&:(= ?capacity 0)))
	
	=>
	
	(modify ?f (eliminado 1))
	(assert (vuelta-atras))
)


(defrule classify
  (declare (salience 199))
  (fase avance)
  (not (vuelta-atras))
  
  (solucion $?head ?shelf-id)
  
  ?e <- (elementos
    (elemento ?shelf-id)
    (posicion ?book-id&:(= ?book-id (+ (length$ $?head) 1)))
  )
  
  ?b <- (bookshelf
    (id ?shelf-id)
    (books $?books)
    (category ?shelf-cat)
    (capacity ?capacity)
  )
  
  (book (id ?book-id) (category ?book-cat & ~?shelf-cat))
  
  =>
  
  (modify ?e (eliminado 1))
  (assert (vuelta-atras))
)
