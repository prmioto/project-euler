(ns project-euler.ex54
    (:require [clojure.string :as str])
    (:require [clojure.java.io :as io]))

(def suit-names
    "Map that associates the letter that represents a card suit." 
    {\H :H \S :S \C :C \D :D})
    
(def kind-names
    "Map that associates the letter that represents a card kind." 
    {\2 :c2 \3 :c3 \4 :c4 \5 :c5 \6 :c6 \7 :c7 \8 :c8 \9 :c9 \T :cT \J :cJ \Q :cQ \K :cK \A :cA})

(def kind-ranks
    "Map that associates the letter that represents a card kind." 
    {:c2 1 :c3 2 :c4 3 :c5 4 :c6 5 :c7 6 :c8 7 :c9 8 :cT 9 :cJ 10 :cQ 11 :cK 12 :cA 13})

(defrecord Card [suit kind rank shorthand])

(defn create-card
  "Creates a card from its shorthand."
  [card-sh]
  (let [suit-sh (second card-sh) kind-sh (first card-sh)]
    (let [suit (suit-names suit-sh) kind (kind-names kind-sh) rank (kind-ranks kind) shorthand card-sh]
        (Card. suit kind rank shorthand))))
  
(defn compare-cards
    "Returns a negative number, zero, or a positive number
    when the card1 has a rank 'less than', 'equal to', or 'greater than' card2."
    [card1 card2]
    (let [card1-rank (:rank card1) card2-rank (:rank card2)]
        (if (= card1-rank card2-rank)
            0
            (if (> card1-rank card2-rank) 1 -1))))
            
(def hand-rank 
    {:high-card 1
     :one-pair 2
     :two-pairs 3
     :three-of-a-kind 4
     :straight 5
     :flush 6
     :full-house 7
     :four-of-a-kind 8
     :straight-flush 9
     :royal-flush 10})

(defn create-hand [hand-str]
    (sort #(> (:rank %1) (:rank %2)) (map create-card (str/split hand-str #" "))))

(defn dump-hand [hand]
    (str/join " " (map #(:shorthand %1) hand)))

(defn consecutive? [sorted-coll]
    (= 1
        (:prod
            (reduce
               #(assoc 
                   {}
                   :prod (* (:prod %1) (- (:prev %1) %2))
                   :prev %2)
               {:prod 1 :prev (first sorted-coll)}
               (rest sorted-coll)))))

(defn consecutive-hand? [hand]
    (consecutive? (map #(:rank %) hand)))

(defn is-straight? [hand]
    (consecutive-hand? hand))

(defn same-suit-hand? [hand]
    (apply = (map #(:suit %) hand)))    

(defn is-flush? [hand]
    (same-suit-hand? hand))

(defn is-straight-flush? [hand]
    (and
        (same-suit-hand? hand)
        (consecutive-hand? hand)))

(def safe-inc (fnil inc 0))

(defn get-kind-frequencies [hand]
    (reduce
        #(assoc %1 (:kind %2) (safe-inc ((:kind %2) %1)))
        (sorted-map)
        hand))

(defn is-n-of-a-kind? [hand n]
    (comment (println (dump-hand hand)))
    (if (nil? (some #(>= % n) (vals (get-kind-frequencies hand))))
        false
        true))

(defn get-pairs-number [hand]
    (reduce
        #(if (= 2 %2) (inc %1) %1)
        0
        (vals (get-kind-frequencies hand))))
        
(defn is-one-pair? [hand]
    (= 1 (get-pairs-number hand)))
    
(defn is-two-pairs? [hand]
    (= 2 (get-pairs-number hand)))
    
(defn is-three-of-a-kind? [hand]
    (is-n-of-a-kind? hand 3))
  
(defn is-four-of-a-kind? [hand]
    (is-n-of-a-kind? hand 4))  
    
(defn is-full-house? [hand]
    (let [frequencies (vals (get-kind-frequencies hand))]
        (comment (println (dump-hand hand) frequencies))
        (= (set [2 3]) (set frequencies))))
        
(defn is-royal-flush? [hand]
    (and
        (same-suit-hand? hand)
        (consecutive-hand? hand)
        (= :cA (:kind (first hand))))) 

(defn get-poker-hand [hand]
    (cond
        (is-royal-flush? hand) :royal-flush
        (is-straight-flush? hand) :straight-flush
        (is-four-of-a-kind? hand) :four-of-a-kind
        (is-full-house? hand) :full-house
        (is-flush? hand) :flush
        (is-straight? hand) :straight
        (is-three-of-a-kind? hand) :three-of-a-kind
        (is-two-pairs? hand) :two-pairs
        (is-one-pair? hand) :one-pair
        :else :high-card))

(defn rank-high-values [hand]
    (sort-by (juxt :freq :rank) #(compare %2 %1)
        (map
            #(assoc {} :rank (kind-ranks (first %)) :freq (second %))
            (seq (get-kind-frequencies hand)))))

(defn solve-tie [hand1 hand2]
    (let
        [freq1 (get-kind-frequencies hand1)
         freq2 (get-kind-frequencies hand2)
         rank1 (rank-high-values hand1)
         rank2 (rank-high-values hand2)]
         (reduce
            #(if (and (= %1 :tie) (not= (first %2) (second %2)))
                (if (> (first %2) (second %2))
                    :hand1-wins
                    :hand2-wins)
                %1)
            :tie
            (map 
                #(vector (:rank %1) (:rank %2))
                rank1
                rank2))))

(defn showdown [hand1 hand2]
    (let 
        [poker-hand1 (get-poker-hand hand1)
         poker-hand2 (get-poker-hand hand2)
         rank-hand1 (hand-rank poker-hand1)
         rank-hand2 (hand-rank poker-hand2)]
         (if (= rank-hand1 rank-hand2)
            (solve-tie hand1 hand2)
            (if (> rank-hand1 rank-hand2) 
                :hand1-wins
                :hand2-wins))))

(let [game-file "resources/test_poker.txt"]
    (with-open [rdr (io/reader game-file)]
        (doseq [line (line-seq rdr)]
            (let 
                [hand1 (create-hand (subs line 0 14))
                 hand2 (create-hand(subs line 15))]
                 (println (showdown hand1 hand2))))))


(println
(let [game-file "resources/p054_poker.txt"]
    (with-open [rdr (io/reader game-file)]
        (count 
            (filter 
                #(= :hand1-wins %)
                (map 
                    #(showdown 
                        (create-hand (subs % 0 14))
                        (create-hand(subs % 15)))
                    (line-seq rdr))))))
)
           
(comment :answer 376)