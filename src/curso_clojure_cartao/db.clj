(ns curso-clojure-cartao.db
  (:require [clj-time.core :as t]))

(def clients [{:client-id 1
               :name "Fulano"
               :cpf 12345600000
               :email "fulano@gmail.com"}
              {:client-id 15
               :name "Maria"
               :cpf 55345600000
               :email "maria@lala.com"}
              {:client-id 30
               :name "José"
               :cpf 99345600000
               :email "jose@uol.com"}])

(def credit-cards [{:card-number 00000000000000
                    :cvv 123
                    :expiry-date (t/date-time 2027 3 31)
                    :limit 3000
                    :client-id 1}
                   {:card-number 111111111111111
                    :cvv 234
                    :expiry-date (t/date-time 2024 1 31)
                    :limit 1000
                    :client-id 15}
                   {:card-number 222222222222222
                    :cvv 235
                    :expiry-date (t/date-time 2025 3 31)
                    :limit 2000
                    :client-id 15}
                   {:card-number 333333333333
                    :cvv 999
                    :expiry-date (t/date-time 2027 4 30)
                    :limit 4000
                    :client-id 1}
                   {:card-number 4444444444444
                    :cvv 432
                    :expiry-date (t/date-time 2027 3 30)
                    :limit 3000
                    :client-id 30}
                   {:card-number 5555555555555
                    :cvv 123
                    :expiry-date (t/date-time 2030 9 30)
                    :limit 10000
                    :client-id 1}])

(def transactions [{:transaction-id 100
                    :date (t/date-time 2021 05 03 4 3 27)
                    :value 30
                    :merchant "Wursteria"
                    :category "alimentacao"
                    :card-number 00000000000000}
                   {:transaction-id 101
                    :date (t/date-time 2021 05 03 4 3 27)
                    :value 100
                    :merchant "Drogarias Pacheco"
                    :category "saude"
                    :card-number 111111111111111}
                   {:transaction-id 102
                    :date (t/date-time 2021 05 04 4 3 27)
                    :value 1
                    :merchant "Casa do Biscoito"
                    :category "mercado"
                    :card-number 222222222222222}
                   {:transaction-id 103
                    :date (t/date-time 2021 05 04 4 3 27)
                    :value 73
                    :merchant "Supermercado Guanabara"
                    :category "mercado"
                    :card-number 111111111111111}
                   {:transaction-id 104
                    :date (t/date-time 2021 05 06 4 3 27)
                    :value 99
                    :merchant "Supermercado Guanabara"
                    :category "mercado"
                    :card-number 333333333333}
                   {:transaction-id 105
                    :date (t/date-time 2021 05 06 4 3 27)
                    :value 300
                    :merchant "Dominos"
                    :category "alimentacao"
                    :card-number 333333333333}
                   {:transaction-id 106
                    :date (t/date-time 2021 05 06 4 3 27)
                    :value 12
                    :merchant "DragaRaia"
                    :category "saude"
                    :card-number 4444444444444}
                   {:transaction-id 107
                    :date (t/date-time 2021 05 10 4 3 27)
                    :value 10
                    :merchant "China in Box"
                    :category "alimentacao"
                    :card-number 4444444444444}
                   {:transaction-id 108
                    :date (t/date-time 2021 05 10 4 3 27)
                    :value 15
                    :merchant "Casa do Biscoito"
                    :category "mercado"
                    :card-number 4444444444444}])