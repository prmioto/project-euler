(ns project-euler.ex46-test
  (:require [clojure.test :refer :all]
            [project-euler.ex46 :refer :all]))

(deftest is-square-test
    (testing "checks if a number is a square integer"
        (is (is-square? 0))
        (is (is-square? 1))
        (is (not (is-square? 2)))
        (is (is-square? 4))
        (is (is-square? 9))
        (is (is-square? 16))
        (is (is-square? 81))
        (is (is-square? 144))))
    
(deftest goldbach-conjecture-test
    (testing "checks if a specified number and a prime support the Goldbach conjecture"
        (is (is-goldbach-conjecture? 27 19))
        (is (is-goldbach-conjecture? 9 7))
        (is (not (is-goldbach-conjecture? 15 9)))))
        
(deftest find-goldbach-prime-test
    (testing "finds the prime for a specified number that satisfies the Goldbach Conjecture"
        (is (= 7 (find-goldbach-prime 9)))
        (is (nil? (find-goldbach-prime 12)))
        (is (= 19 (find-goldbach-prime 27)))))
        
