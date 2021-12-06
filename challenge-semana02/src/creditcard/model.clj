(ns creditcard.model
  (:require [schema.core :as s]
            [java-time :as jt]))

(defn valid-card? [x] (= (count x) 16))
(def CreditCardNumber (s/constrained s/Str valid-card? 'credit-card-invalid))

(defn valid-date? [x] (jt/local-date-time? (jt/local-date-time x)))
(def Date (s/constrained s/Str valid-date?))

(defn valid-value? [x] (not (neg? x)))
(def Value (s/constrained s/Num valid-value?))

(s/def Record
  "A schema for a record"
  {:creditcard-number CreditCardNumber
   :date              Date
   :value             Value
   :place             s/Str
   :category          s/Str})
