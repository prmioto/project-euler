(ns project-euler.ex54-test
  (:require [clojure.test :refer :all]
            [project-euler.ex54 :refer :all]))

(deftest create-card-tests
  (let [card (create-card "4D")] 
  (testing
    (is (= :c4 (:kind card)))            
    (is (= :D (:suit card))))))
    
(deftest create-hand-tests
  (let [hand (create-hand "6D 9H 5C 2H KS")]
  (testing
    (is (= :cK (:kind (first hand))))          
    (is (= :S (:suit (first hand))))
    (is (= :c2 (:kind (last hand))))
    (is (= :H (:suit (last hand)))))))
        
(deftest dump-hand-tests
  (testing
    (is (= "KS 9H 6D 5C 2H" (dump-hand (create-hand "6D 9H 5C KS 2H"))))))

(deftest consecutive-tests
    (testing
        (is (true? (consecutive? [13])))
        (is (true? (consecutive? [13 12])))
        (is (true? (consecutive? [13 12 11 10])))
        (is (false? (consecutive? [13 11 10 9])))
        (is (false? (consecutive? [13 12 11 11])))))

(deftest consecutive-hand-tests
    (let [consecutive-test-hand (create-hand "6H 4H 5C 3H 2H")
          generic-test-hand (create-hand "6D 9H 5C KS 2H")]
        (testing
            (is (true? (consecutive-hand? consecutive-test-hand)))
            (is (false? (consecutive-hand? generic-test-hand))))))
            
(deftest is-straight-tests
    (let [straight-test-hand (create-hand "6H 4H 5C 3H 2H")
          generic-test-hand  (create-hand "6D 9H 5C KS 2H")]
        (testing 
            (is (true? (is-straight? straight-test-hand)))
            (is (false? (is-straight? generic-test-hand))))))

(deftest same-suit-hand-tests
    (let [same-suit-test-hand (create-hand "6C 4C 5C 3C 2C")
          generic-test-hand (create-hand "6D 9H 5C KS 2H")]
        (testing 
            (is (true? (same-suit-hand? same-suit-test-hand)))
            (is (false? (same-suit-hand? generic-test-hand))))))

(deftest is-flush-tests
    (let [flush-test-hand (create-hand "4C QC QC AC KC")
          generic-test-hand (create-hand "6D 9H 5C KS 2H")]
        (testing 
            (is (true? (is-flush? flush-test-hand)))
            (is (false? (is-flush? generic-test-hand))))))

(deftest is-straight-flush-tests
    (let [straight-flush-test-hand (create-hand "6C 4C 5C 3C 2C")
          generic-test-hand (create-hand "6D 9H 5C KS 2H")]
        (testing 
            (is (true? (is-straight-flush? straight-flush-test-hand))))
            (is (false? (is-straight-flush? generic-test-hand)))))
            
(deftest get-kind-frequencies-tests
    (let [test-hand1 (create-hand "4C 4H 4D 4S KC")
          test-hand2 (create-hand "4C 4H 4D 5C 5S")
          test-hand3 (create-hand "4C QC QD AC KC")]
          (testing 
        (is (= {:c4 4, :c5 1} (get-kind-frequencies test-hand1)))
        (is (= {:c4 3, :c5 2} (get-kind-frequencies test-hand2)))
        (is (= {:c4 1, :cA 1, :cK 1, :cQ 2} (get-kind-frequencies test-hand2))))))
        
(deftest get-kind-frequencies-tests
    (let [three-of-a-kind-test-hand (create-hand "4C QC QH QD KC")
          four-of-a-kind-test-hand (create-hand "4C QC QH QD QS")
          generic-test-hand (create-hand "6D 9H 5C KS 2H")]
        (testing 
            (is (true? (is-n-of-a-kind? three-of-a-kind-test-hand 3)))
            (is (true? (is-n-of-a-kind? four-of-a-kind-test-hand 4)))
            (is (false? (is-n-of-a-kind? generic-test-hand 4))))))
           
(deftest one-pair-tests
    (let [one-pair-test-hand (create-hand "4C QC QH 6D KC")
          generic-test-hand (create-hand "6D 9H 5C KS 2H")]
        (testing 
            (is (true? (is-one-pair? one-pair-test-hand))))
            (is (false? (is-one-pair? generic-test-hand)))))   
            
(deftest two-pairs-tests
    (let [two-pairs-test-hand (create-hand "4C QC QH KD KC")
          generic-test-hand (create-hand "6D 9H 5C KS 2H")]
        (testing 
            (is (true? (is-two-pairs? two-pairs-test-hand)))
            (is (false? (is-two-pairs? generic-test-hand)))))) 
           
(deftest is-three-of-a-kind-tests
    (let [three-of-a-kind-test-hand (create-hand "4C QC QH QD KC")
          generic-test-hand (create-hand "6D 9H 5C KS 2H")]
        (testing 
            (is (true? (is-three-of-a-kind? three-of-a-kind-test-hand)))
            (is (false? (is-three-of-a-kind? generic-test-hand))))))

(deftest is-four-of-a-kind-tests
    (let [four-of-a-kind-test-hand (create-hand "4C QC QH QD QS")
          generic-test-hand (create-hand "6D 9H 5C KS 2H")]
        (testing 
            (is (true? (is-four-of-a-kind? four-of-a-kind-test-hand)))
            (is (false? (is-four-of-a-kind? generic-test-hand))))))
            
(deftest is-full-house-tests
    (let [full-house-test-hand (create-hand "4C QC QH QD 4S")
          generic-test-hand (create-hand "6D 9H 5C KS 2H")]
        (testing 
            (is (true? (is-full-house? full-house-test-hand)))
            (is (false? (is-full-house? generic-test-hand))))))

(deftest is-royal-flush-tests
    (let [royal-flush-test-hand (create-hand "JC TC QC AC KC")
          generic-test-hand (create-hand "6D 9H 5C KS 2H")]
        (testing 
            (is (true? (is-royal-flush? royal-flush-test-hand)))
            (is (false? (is-royal-flush? generic-test-hand))))))

(deftest get-poker-hand-tests
    (let [one-pair-test-hand (create-hand "4C QC QH 6D KC")
          two-pairs-test-hand (create-hand "4C QC QH KD KC")
          three-of-a-kind-test-hand (create-hand "4C QC QH QD KC")
          straight-test-hand (create-hand "6H 4H 5C 3H 2H")
          flush-test-hand (create-hand "4C QC QC AC KC")
          full-house-test-hand (create-hand "4C QC QH QD 4S")
          four-of-a-kind-test-hand (create-hand "4C QC QH QD QS")
          straight-flush-test-hand (create-hand "6C 4C 5C 3C 2C")
          royal-flush-test-hand (create-hand "JC TC QC AC KC")
          generic-test-hand (create-hand "6D 9H 5C KS 2H")]         
        (testing           
            (is (= :one-pair (get-poker-hand one-pair-test-hand)))
            (is (= :two-pairs (get-poker-hand two-pairs-test-hand)))          
            (is (= :three-of-a-kind (get-poker-hand three-of-a-kind-test-hand)))
            (is (= :straight (get-poker-hand straight-test-hand)))
            (is (= :flush (get-poker-hand flush-test-hand)))
            (is (= :full-house (get-poker-hand full-house-test-hand)))
            (is (= :four-of-a-kind (get-poker-hand four-of-a-kind-test-hand)))
            (is (= :straight-flush (get-poker-hand straight-flush-test-hand)))
            (is (= :royal-flush (get-poker-hand royal-flush-test-hand)))
            (is (= :high-card (get-poker-hand generic-test-hand))))))
          
(deftest rank-high-values-tests
    (let [test-hand1 (create-hand "4C 4H 4D 4S KC")
          test-hand2 (create-hand "4C 4H 4D 5C 5S")
          test-hand3 (create-hand "4C QC QD AC KC")]
        (testing
            (is (= 
                '({:rank 3, :freq 4} {:rank 12, :freq 1})
                (rank-high-values test-hand1)))
            (is (= 
                '({:rank 3, :freq 3} {:rank 4, :freq 2})
                (rank-high-values test-hand2)))
            (is (= 
                '({:rank 11, :freq 2} {:rank 13, :freq 1} {:rank 12, :freq 1} {:rank 3, :freq 1})
                (rank-high-values test-hand3))))))
                
(deftest solve-tie-tests
    (let [test-hand1 (create-hand "4C 4H QD QS KC")
          test-hand2 (create-hand "4C 6H KD KC 5S")
          test-hand3 (create-hand "4C 4C QD QC KC")
          generic-test-hand1 (create-hand "6D 9H 5C JS 2H")
          generic-test-hand2 (create-hand "3H 7S 2D QC 4H")]
        (testing           
            (is (= :hand2-wins (solve-tie test-hand1 test-hand2)))
            (is (= :hand1-wins (solve-tie test-hand2 test-hand3)))
            (is (= :hand2-wins (solve-tie generic-test-hand1 generic-test-hand2))))))
                     
(deftest showdown-highest-value-tests      
     (testing "Highest value"  
        (let [generic-test-hand1 (create-hand "6D 9H 5C JS 2H")
              generic-test-hand2 (create-hand "3H 7S 2D QC 4H")]         
            (is (= :hand2-wins (showdown generic-test-hand1 generic-test-hand2))))))

(deftest showdown-different-ranked-hands-tests              
    (testing "Different ranked hands, no ties"  
        (let [one-pair-test-hand (create-hand "4C QC QH 6D KC")
              two-pairs-test-hand (create-hand "4C QC QH KD KC")
              three-of-a-kind-test-hand (create-hand "4C QC QH QD KC")
              straight-test-hand (create-hand "6H 4H 5C 3H 2H")
              flush-test-hand (create-hand "4C QC QC AC KC")
              full-house-test-hand (create-hand "4C QC QH QD 4S")
              four-of-a-kind-test-hand (create-hand "4C QC QH QD QS")
              straight-flush-test-hand (create-hand "6C 4C 5C 3C 2C")
              royal-flush-test-hand (create-hand "JC TC QC AC KC")
              generic-test-hand (create-hand "6D 9H 5C KS 2H")]         
            (is (= :hand1-wins (showdown one-pair-test-hand generic-test-hand)))
            (is (= :hand2-wins (showdown one-pair-test-hand two-pairs-test-hand)))
            (is (= :hand1-wins (showdown three-of-a-kind-test-hand two-pairs-test-hand)))
            (is (= :hand2-wins (showdown three-of-a-kind-test-hand full-house-test-hand)))
            (is (= :hand1-wins (showdown four-of-a-kind-test-hand full-house-test-hand)))
            (is (= :hand1-wins (showdown royal-flush-test-hand straight-flush-test-hand)))
            (is (= :tie (showdown one-pair-test-hand one-pair-test-hand))))))

(deftest showdown-same-ranked-hands-tests  
    (testing "Same ranked hands, rank made up of the highest value."  
        (let [three-of-a-kind-test-hand1 (create-hand "4C QC QH QD KC")
              three-of-a-kind-test-hand2 (create-hand "4C JC JH JD KC")
              straight-test-hand1 (create-hand "6H 4H 5C 3H 2H")
              straight-test-hand2 (create-hand "7H 4H 5C 3H 6H")
              flush-test-hand1 (create-hand "4C JC QC AC KC")
              flush-test-hand2 (create-hand "4C QC QC AC KC")
              straight-flush-test-hand1 (create-hand "6C 4C 5C 3C 2C")
              straight-flush-test-hand2 (create-hand "6C 4C 5C 3C 7C")]         
            (is (= :hand1-wins (showdown three-of-a-kind-test-hand1 three-of-a-kind-test-hand2)))
            (is (= :hand2-wins (showdown straight-test-hand1 straight-test-hand2)))
            (is (= :hand1-wins (showdown flush-test-hand1 flush-test-hand2)))
            (is (= :hand2-wins (showdown straight-flush-test-hand1 straight-flush-test-hand2))))))