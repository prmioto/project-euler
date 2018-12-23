(ns project-euler.permutations-test
  (:require [clojure.test :refer :all]
            [project-euler.permutations :refer :all]))

(deftest join-tests
         (testing 
               (is (= '(1 2 3 4 5 6) (join '(1 2 3) '(4 5 6))))))
               
(deftest add-to-begin-tests
         (testing 
               (is (= '(4 1 2 3) (add-to-begin '(1 2 3) 4)))
               (is (= '(4 1 2 3) (add-to-begin [1 2 3] 4)))))   
               
(deftest add-to-end-tests
         (testing 
               (is (= '(1 2 3 4) (add-to-end '(1 2 3) 4)))
               (is (= '(1 2 3 4) (add-to-end [1 2 3] 4)))))               

(deftest rotate-left-tests
  (testing 
    (is (= '(2 3 1) (rotate-left '(1 2 3) 1)))
    (is (= '(1 2 3 4 5) (rotate-left '(1 2 3 4 5) 0)))
    (is (= '(2 3 4 5 1) (rotate-left '(1 2 3 4 5) 1)))
    (is (= '(3 4 5 1 2) (rotate-left '(1 2 3 4 5) 2)))))

(deftest rotate-all-tests
  (testing 
    (is (= '((1 2 3) (2 3 1) (3 1 2) (rotate-all '(1 2 3)))))
    (is (= '((1)) (rotate-all '(1))))))


(deftest conj-to-all-tests
  (testing
    (is (= '((7 1 2 3) (7 3 4 5 6)) (conj-to-all '((1 2 3) (3 4 5 6)) 7)))))
        

(deftest permutate-tests
  (testing
    (is (= '((1)) (permutate '(1))))
    (is (= '((1 2) (2 1)) (permutate '(1 2))))
    (is (= '((1 2 3) (1 3 2) (2 3 1) (2 1 3) (3 1 2) (3 2 1)) (permutate '(1 2 3))))
    (is (= 120 (count (permutate '(1 2 3 4 5)))))
    (is (= 720 (count (permutate '(:a :b :c :d :e :f)))))
    (is (= '("ROM" "RMO" "OMR" "ORM" "MRO" "MOR") (map #(apply str %) (permutate (seq "ROM")))))))

(deftest anagram-tests
  (testing
    (is (= '("AB" "BA") (anagram "AB")))
    (is (= '("ROM" "RMO" "OMR" "ORM" "MRO" "MOR")) (anagram "ROM"))
    (is (= '("ABA" "AAB" "BAA")) (anagram "ABA"))))





