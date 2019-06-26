----Every RDF file----
-[Yes] Uses the .ttl extension
-[Yes] Is serialized in the Turtle format
-[Yes] Follows theresource naming strategy
-[Yes] Uses class and property URIs that are the same as those used in the ontology

----Every URI in the RDF files----
-[Yes] Is "readable" and has some meaning (e.g., it is not an auto-increased integer) 
-[Yes] Is not encoded as a string
-[Yes] Does not contain a double slash (i.e., “//”)

----Every individual in the RDF files----
-[Yes] Has a label with the name of the individual
-[Yes] Has a type

----Every value in the RDF files----
Is not empty (i.e., “”)
-[Yes] Is trimmed
-[Yes] Is properly encoded (e.g., dates, booleans)
-[Yes] Includes its datatype
-[Yes] Uses the correct datatype (e.g., values of 0-1 may be booleansand not integers, not every string made of numbers is a number)