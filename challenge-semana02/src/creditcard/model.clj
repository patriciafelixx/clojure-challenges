(ns creditcard.model
  (:require [schema.core :as s]))

(s/def Record
  "A schema for a record"
  {:creditcard-number s/Str
     :date s/Str
     :value s/Num
     :place s/Str
     :category s/Str})
