(ns creditcard.model)

(defn uuid []
  (java.util.UUID/randomUUID))

(defn dateformat [date]
  (.parse (java.text.SimpleDateFormat. "dd/MM/yyyy") date))

(defn customer
  ([name cpf email]
   (customer (uuid) name cpf email))
  ([uuid name cpf email]
   {:customer/id    uuid
    :customer/name  name
    :customer/cpf   cpf
    :customer/email email}))

(defn creditcard
  ([number validate limit cvv]
   (creditcard (uuid) number validate limit cvv))
  ([uuid number validate limit cvv]
  {:creditcard/id       uuid
   :creditcard/number   number
   :creditcard/validate (dateformat validate)
   :creditcard/limit    limit
   :creditcard/cvv      cvv}))

(defn transaction
  ([value place category]
   (transaction (uuid) (java.util.Date.) value place category))
  ([uuid date value place category]
  {:transaction/id       uuid
   :transaction/date     date
   :transaction/value    value
   :transaction/place    place
   :transaction/category category}))
