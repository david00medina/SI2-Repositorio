(deffacts ordenar
	(list 11 81 92 39 2 0 93 76)
)

(defrule doordenar
	?f<-(list $?head ?a ?b&:(< ?b ?a) $?tail)
=>
	(retract ?f)
	(assert (list $?head ?b ?a  $?tail))
)