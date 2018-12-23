(ns project-euler.core-test
  (:require [clojure.test :refer :all]
            [project-euler.core :refer :all]))

(deftest find-first-test
    (testing "tests the find-first function"
       (is (= 10 (find-first #(> % 9) (range 1 1000))))
       (is (nil? (find-first #(> % 9) '())))
       (is (= 10 (find-first #(> % 9) (iterate inc 1))))))

(deftest divisors-test
    (testing "tests for all divisors of a specified integer"
        (is (= '() (divisors 0)))
        (is (= '(1) (divisors 1)))
        (is (= '(1 2) (divisors 2)))
        (is (= '(1 7) (divisors 7)))
        (is (= '(1 2 7 14) (divisors 14)))
        (is (= '(1 2 4 8 16) (divisors 16)))
        (is (= '(1 2 4 13 26 52) (divisors 52)))))
        
(deftest prime-factors-test
    (testing "tests for all prime factors of a specified integer"
        (is (= '() (prime-factors 1)))
        (is (= '() (prime-factors 2)))
        (is (= '() (prime-factors 7)))
        (is (= '(2 7) (prime-factors 14)))
        (is (= '(2) (prime-factors 16)))
        (is (= '(2 13) (prime-factors 52)))))
        
(deftest is-composite-test
  (testing "checks if a number is composite or not"
    (is (not (composite? 0)))
    (is (not (composite? 1)))
    (is (not (composite? 2)))
    (is (not (composite? 3)))
    (is (composite? 4))
    (is (not (composite? 5)))
    (is (not (composite? 7)))
    (is (composite? 8))
    (is (composite? 9))
    (is (not (composite? 11)))
    (is (not (composite? 31)))
    (is (not (composite? 79)))
    (is (composite? 80))))
    
(deftest is-prime-test
  (testing "checks if a number is prime or not"
    (is (not (prime? 0)))
    (is (not (prime? 1)))
    (is (prime? 2))
    (is (prime? 3))
    (is (not (prime? 4)))
    (is (prime? 5))
    (is (prime? 7))
    (is (not (prime? 8)))
    (is (not (prime? 9)))
    (is (prime? 11))
    (is (prime? 31))
    (is (prime? 79))
    (is (not (prime? 80)))))

(deftest odd-composites-test
    (testing "tests the list of odd composites numbers"
        (is (= '(9 15 21 25 27 33) (take 6 (odd-composites))))))
    
(deftest primes-below-test
    (testing "tests the list of primes below a specified number"
        (is (= '() (primes-below 1)))
        (is (= '() (primes-below 2)))
        (is (= '(2) (primes-below 3)))
        (is (= '(2 3) (primes-below 4)))
        (is (= '(2 3 5) (primes-below 6)))
        (is (= '(2 3 5 7 11 13) (primes-below 17))))
        (is (= '(2 3 5 7 11 13 17 19 23 29 31 37 41 43 47) (primes-below 50))))
        (is (= '(2 3 5 7 11 13 17 19 23 29 31 37 41 43 47 53 59 61 67 71 73 79 83 89 97) (primes-below 100)))