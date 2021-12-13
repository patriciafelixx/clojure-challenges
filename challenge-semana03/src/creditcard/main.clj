(ns creditcard.main
  (:use clojure.pprint)
  (:require [datomic.api :as d]
            [creditcard.db :as db]
            [creditcard.model :as model]))

(db/delete-db!)

(def conn (db/connection))
(db/create-schema! conn)

; --------------------------------------------------------------------------------------------------------------------
; customerS

(def customer1 (model/customer "Luca", "12345678910", "luca@email.com"))
(def customer2 (model/customer "Iara", "23145678990", "iara@email.com"))
(def customer3 (model/customer "Theo", "45657215478", "theo@email.com"))
(db/add-customer! conn [customer1, customer2, customer3])

(db/all-customers (d/db conn))

; --------------------------------------------------------------------------------------------------------------------
; CREDIT CARDS

(def card1 (model/creditcard "1654658431352967", "07/10/2028", 5000M, 321))
(def card2 (model/creditcard "9876543210987654", "23/01/2029", 800M, 469))
(def card3 (model/creditcard "1478523694563219", "13/12/2025", 200M, 456))
(db/add-creditcard! conn [card1, card2, card3])

(db/assign-card-to-customer! conn card1 customer1)
(db/assign-card-to-customer! conn card2 customer2)
(db/assign-card-to-customer! conn card3 customer3)
(db/all-creditcards (d/db conn))

; --------------------------------------------------------------------------------------------------------------------
; TRANSACTIONS

(def tr1 (model/transaction 100M, "Padaria", "Alimentação"))
(def tr2 (model/transaction (model/uuid), (java.util.Date.), 100M, "Padaria", "Alimentação"))
(def tr3 (model/transaction (model/uuid), #inst"2021-10-21T08:34:26", 100M, "Posto de Gasolina", "Transporte"))
(def tr4 (model/transaction (model/uuid), #inst"2021-10-24T09:35:00", 80M, "Pizzaria", "Alimentação"))
(def tr5 (model/transaction (model/uuid), #inst"2021-10-25T10:37:15", 150M, "Dentista", "Saúde"))
(def tr6 (model/transaction (model/uuid), #inst"2021-10-28T18:20:20", 90M, "Cinema", "Lazer"))
(def tr7 (model/transaction (model/uuid), #inst"2021-10-28T21:55:05", 30M, "Taxi", "Transporte"))
(def tr8 (model/transaction (model/uuid), #inst"2021-10-30T16:07:05", 20M, "Padaria", "Alimentação"))
(def tr9 (model/transaction (model/uuid), #inst"2021-11-01T09:30:11", 700M, "Supermercado", "Alimentação"))
(def tr10 (model/transaction (model/uuid), #inst"2021-11-02T12:12:12", 140M, "Parque", "Lazer"))
(def tr11 (model/transaction (model/uuid), #inst"2021-11-05T18:22:24", 60M, "Papelaria", "Estudos"))
(def tr12 (model/transaction (model/uuid), #inst"2021-11-05T18:37:25", 350M, "Curso", "Estudos"))
(def tr13 (model/transaction (model/uuid), #inst"2021-11-07T08:40:12", 120M, "Posto de Gasolina", "Transporte"))
(def tr14 (model/transaction (model/uuid), #inst"2021-11-07T09:07:01", 35M, "Padaria", "Alimentação"))
(def tr15 (model/transaction (model/uuid), #inst"2021-11-10T11:10:15", 65M, "Taxi", "Transporte"))
(def tr16 (model/transaction (model/uuid), #inst"2021-11-10T17:30:45", 200M, "Supermercado", "Alimentação"))
(def tr17 (model/transaction (model/uuid), #inst"2021-11-11T17:45:28", 45M, "Taxi", "Transporte"))

(db/add-transaction! conn [tr1, tr2, tr3, tr4, tr5, tr6, tr7, tr8, tr9, tr10, tr11, tr12, tr13, tr14, tr15, tr16, tr17])
(db/assign-transactions-to-card! conn tr1 card1)
(db/assign-transactions-to-card! conn tr2 card1)
(db/assign-transactions-to-card! conn tr3 card1)
(db/assign-transactions-to-card! conn tr4 card2)
(db/assign-transactions-to-card! conn tr5 card2)
(db/assign-transactions-to-card! conn tr6 card1)
(db/assign-transactions-to-card! conn tr7 card2)
(db/assign-transactions-to-card! conn tr8 card2)
(db/assign-transactions-to-card! conn tr9 card1)
(db/assign-transactions-to-card! conn tr10 card1)
(db/assign-transactions-to-card! conn tr11 card2)
(db/assign-transactions-to-card! conn tr12 card2)
(db/assign-transactions-to-card! conn tr13 card2)
(db/assign-transactions-to-card! conn tr14 card2)
(db/assign-transactions-to-card! conn tr15 card1)
(db/assign-transactions-to-card! conn tr16 card1)
(db/assign-transactions-to-card! conn tr17 card2)
(db/all-transactions (d/db conn))

; --------------------------------------------------------------------------------------------------------------------

(db/transactions-by-card (d/db conn) "1654658431352967")
(db/transactions-by-card (d/db conn) "9876543210987654")
(db/transactions-by-card (d/db conn) "1478523694563219")

(db/transactions-by-customer (d/db conn) "12345678910")
(db/transactions-by-customer (d/db conn) "23145678990")
(db/transactions-by-customer (d/db conn) "45657215478")
