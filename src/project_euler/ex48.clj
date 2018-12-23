(ns project-euler.ex48)
(require '[clojure.string :as string])

(defn last-chars [s n]
    (string/reverse (subs (string/reverse s) 0 n)))
    
(defn power [base exp]
    (loop [i exp acc 1]
        (if (zero? i)
          acc
          (recur (dec i) (* acc base)))))

(defn self-power [n]
    (loop [i n acc 0]
        (if (zero? i)
            acc
            (recur (dec i) (+ acc (power i i))))))
            
;answer=9027641920