(ns creditcard.db
  (:use clojure.pprint)
  (:require [datomic.api :as d]
            [creditcard.schema :as s]))

(def db-uri "datomic:dev://localhost:4334/creditcard")

(defn connection []
  (d/create-database db-uri)
  (d/connect db-uri))

(defn create-schema! [connection]
  (d/transact connection s/schema))

(defn delete-db! []
  (d/delete-database db-uri))

; --------------------------------------------------------------------------------------------------------------------
; customerS

(defn add-customer! [conn customer]
  (d/transact conn customer))

(defn all-customers [db]
  (d/q '[:find (pull ?e [*])
         :where [?e :customer/name]] db))

; --------------------------------------------------------------------------------------------------------------------
; CREDIT CARDS

(defn add-creditcard! [conn creditcard]
  (d/transact conn creditcard))

(defn all-creditcards [db]
  (d/q '[:find (pull ?e [*])
         :where [?e :creditcard/number]] db))

(defn assign-card-to-customer! [conn creditcard customer]
  (d/transact conn [[:db/add [:creditcard/id (:creditcard/id creditcard)]
                     :creditcard/customer [:customer/id (:customer/id customer)]]]))

; --------------------------------------------------------------------------------------------------------------------
; TRANSACTIONS

(defn add-transaction! [conn transaction]
  (d/transact conn transaction))

(defn all-transactions [db]
  (d/q '[:find (pull ?e [*])
         :where [?e :transaction/id]] db))

(defn assign-transactions-to-card! [conn transaction creditcard]
  (d/transact conn [[:db/add [:transaction/id (:transaction/id transaction)]
                     :transaction/card [:creditcard/id (:creditcard/id creditcard)]]]))

; --------------------------------------------------------------------------------------------------------------------
; REPORTS

(defn transactions-by-card [db, card-number]
  (d/q '[:find (pull ?tr [*])
         :in $ ?card-number
         :where [?e :creditcard/number ?card-number]
         [?tr :transaction/card ?e]]
       db, card-number))

(defn transactions-by-customer [db, customer-cpf]
  (d/q '[:find (pull ?customer [:customer/name :customer/cpf]),
         (pull ?card [:creditcard/number]),
         (pull ?tr [*])
         :in $ ?customer-cpf
         :where [?customer :customer/cpf ?customer-cpf]
         [?card :creditcard/customer ?customer]
         [?tr :transaction/card ?card]
         ]
       db, customer-cpf))