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
; COSTUMERS

(defn add-costumer! [conn costumer]
  (d/transact conn costumer))

(defn all-costumers [db]
  (d/q '[:find (pull ?e [*])
         :where [?e :costumer/name]] db))

; --------------------------------------------------------------------------------------------------------------------
; CREDIT CARDS

(defn add-creditcard! [conn creditcard]
  (d/transact conn creditcard))

(defn all-creditcards [db]
  (d/q '[:find (pull ?e [*])
         :where [?e :creditcard/number]] db))

(defn assign-card-to-customer! [conn creditcard customer]
  (d/transact conn [[:db/add [:creditcard/id (:creditcard/id creditcard)]
                     :creditcard/customer [:costumer/id (:costumer/id customer)]]]))

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
