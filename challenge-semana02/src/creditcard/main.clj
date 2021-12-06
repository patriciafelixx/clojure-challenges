(ns creditcard.main
  (:require [creditcard.logic :as c.logic]))

(println "TOTAL BY CATEGORIES"
         (c.logic/total-by-item (c.logic/all-records) :category))

(println "TOTAL BY PLACES"
         (c.logic/total-by-item (c.logic/all-records) :place))

(println "--------------------------------------------------------")

(println "FILTER BY PLACE: Padaria"
         (c.logic/filter-by-item (c.logic/all-records) :place "Padaria"))

(println "FILTER BY VALUE: 100.00"
         (c.logic/filter-by-item (c.logic/all-records) :value 100.00))

(println "--------------------------------------------------------")

(println "CREDIT CARD INVOICE: October"
         (c.logic/invoice "1654658431352967" "01/10/2021"))

(println "CREDIT CARD INVOICE: November"
         (c.logic/invoice "1654658431352967" "01/11/2021"))

(println "--------------------------------------------------------")

(println "INSERT NEW RECORD"
         (c.logic/new-record
           (c.logic/all-records), "1654658431352967", "2021-12-06T11:30:00", 20000.00, "Plano de Saúde", "Saúde"))