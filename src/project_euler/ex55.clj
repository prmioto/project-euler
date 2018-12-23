(ns project-euler.ex55
  (:require [project-euler.core :as core]))
    
(defn reverse-number [n]
     (core/str-to-bigint (apply str (reverse (str n)))))
   
(defn palindrome? [n]
    (let [initial-str (seq (str n))]
        (loop [test-str initial-str]
            (if (<= (count test-str) 1)
                true
                (if (not= (first test-str) (last test-str))
                    false
                    (recur (drop-last (rest test-str))))))))

(defn likely-lychrel-number? [number-to-test max-iterations]
    (loop [n number-to-test iteration 1]
        (if (> iteration max-iterations)
            true
            (let [new-number (+ n (reverse-number n))]
                (comment (println n new-number))
                (if (palindrome? new-number)
                    false
                    (recur new-number (inc iteration)))))))

(count (filter true? (map #(likely-lychrel-number? % 50) (range 1N 10001N))))
