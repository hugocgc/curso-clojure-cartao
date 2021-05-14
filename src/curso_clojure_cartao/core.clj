(ns curso-clojure-cartao.core
  (:gen-class)
  (:require [clj-time.core :as t])
  (:require [curso-clojure-cartao.db :as db]))

(defn client-by-id
  [client-id clients]
  (filter #(= (:client-id %) client-id) clients))

(defn credit-card-by-number
  [card-number credit-cards]
  (filter #(= (:card-number %) card-number) credit-cards))

(defn credit-card-transactions
  [card-number transactions]
  (filter #(= (:card-number %) card-number) transactions))

(defn client-credit-cards
  [client-id credit-cards]
  (->> (filter #(= (:client-id %) client-id) credit-cards)
       (map :card-number)))

(defn client-transactions
  [client-id credit-cards transactions]
  (->> (client-credit-cards client-id credit-cards)
       (map #(credit-card-transactions % transactions))
       (flatten)))

(defn transactions-grouped-by-category
  [transactions]
  (group-by :category transactions))

(defn billing-statement
  [month transactions]
  (filter
   #(= month (t/month (:date %)))
   transactions))

(defn transactions-total-value
  [transactions]
  (->> (map :value transactions)
       (reduce +)))

(defn search-transaction
  [key value transactions]
  (filter
   #(= (key %) value)
   transactions))


;;Representação dos dados do cliente (nome, cpf, email)
(client-by-id 1 db/clients)
(client-by-id 15 db/clients)

;;Representação dos dados do cartão (número, cvv, validade, limite)
(credit-card-by-number 111111111111111 db/credit-cards)
(credit-card-by-number 4444444444444 db/credit-cards)

;;Listagem de compras realizadas (data, valor, estabelecimento, categoria)
(credit-card-transactions 111111111111111 db/transactions)
(credit-card-transactions 4444444444444 db/transactions)

;;Valor dos gastos agrupados por categoria
(def my-card-transactions1 (credit-card-transactions 111111111111111 db/transactions))
(def my-card-transactions2 (credit-card-transactions 4444444444444 db/transactions))
(transactions-grouped-by-category my-card-transactions1)
(transactions-grouped-by-category my-card-transactions2)


;;Cálculo do valor da fatura do mês (opcional)
(def my-billing-statement (billing-statement 5 my-card-transactions1))
(transactions-total-value my-billing-statement)

;;Busca de compras pelo valor ou estabelecimento (opcional)
(search-transaction :merchant "Casa do Biscoito" my-card-transactions2)
