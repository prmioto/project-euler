(ns project-euler.ex43-test
  (:require [clojure.test :refer :all]
            [project-euler.ex43 :refer :all]))

(deftest a-test
  (testing "generate string triplets from a string"
    (is (= '("123" "234" "345" "456" "567" "678" "789") (get-str-triplets "0123456789"))))
  (testing "generate integer triplets from a string"
    (is (= '(123 234 345 456 567 678 789) (get-int-triplets "0123456789"))))
  (testing "checks if a list of integers is divisible by all elements of another list"
    (is (is-divisible? '(30 60) '(2 3 5)))))
