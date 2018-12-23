(ns project-euler.ex45-test
  (:require [clojure.test :refer :all]
            [project-euler.ex45 :refer :all]))

(deftest calculate-triangle-numbers-test
  (testing "calculate triangle numbers"
    (is (= 1 (triangle-number 1)))
    (is (= 3 (triangle-number 2)))
    (is (= 6 (triangle-number 3))))
  (testing "calculate first 10 triangle numbers"
    (is (= '(1, 3, 6, 10, 15, 21, 28, 36, 45, 55) (take 10 (map triangle-number (iterate inc 1)))))))

(deftest triangle-number-test
  (testing "check if is a triangle number"
    (is (is-triangle-number? 1))
    (is (is-triangle-number? 15))
    (is (not (is-triangle-number? 7)))
    (is (not (is-triangle-number? 1557)))))
    
(deftest calculate-pentagonal-numbers-test
  (testing "calculate pentagonal numbers"
    (is (= 1 (pentagonal-number 1)))
    (is (= 5 (pentagonal-number 2)))
    (is (= 12 (pentagonal-number 3))))
  (testing "calculate first 10 pentagonal numbers"
    (is (= '(1, 5, 12, 22, 35, 51, 70, 92, 117, 145) (take 10 (map pentagonal-number (iterate inc 1)))))))

(deftest pentagonal-number-test
  (testing "check if is a pentagonal number"
    (is (is-pentagonal-number? 1))
    (is (is-pentagonal-number? 35))
    (is (is-pentagonal-number? 145))
    (is (not (is-pentagonal-number? 1557)))))
    
(deftest calculate-hexagonal-numbers-test
  (testing "calculate hexagonal numbers"
    (is (= 1 (hexagonal-number 1)))
    (is (= 6 (hexagonal-number 2)))
    (is (= 15 (hexagonal-number 3))))
  (testing "calculate first 10 hexagonal numbers"
    (is (= '(1, 6, 15,28, 45, 66, 91, 120, 153, 190) (take 10 (map hexagonal-number (iterate inc 1)))))))
    
(deftest hexagonal-number-test
  (testing "check if is a hexagonal number"
    (is (is-hexagonal-number? 1))
    (is (is-hexagonal-number? 66))
    (is (is-hexagonal-number? 120))
    (is (not (is-hexagonal-number? 46)))))
    
(deftest triangle-pentagonal-hexagonal-number-test
  (testing "check if is a triangle and a pentagonal and a hexagonal number"
    (is (not (is-triangle-pentagonal-hexagonal-number? 3)))
    (is (not (is-triangle-pentagonal-hexagonal-number? 5)))
    (is (not (is-triangle-pentagonal-hexagonal-number? 6)))
    (is (not (is-triangle-pentagonal-hexagonal-number? 15)))
    (is (is-triangle-pentagonal-hexagonal-number? 40755))))

(deftest find-next-number-test
    (testing "find next number that is a triangle and a pentagonal and a hexagonal number at the same time"
        (is (= 1 (find-next-number 1)))
        (is (= 40755 (find-next-number 2)))))

