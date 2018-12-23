(ns project-euler.ex53)

(defn factorial [n]
    (loop [i (biginteger n) res 1]
        (if (<= i 1)
            res
            (recur (dec i) (* res i)))))

(defn combinations [n r]
    (/ (factorial n) (* (factorial r) (factorial (- n r)))))

(defn combinations-greater-than [n v]
    (filter 
        #(> (:c %) v) 
        (map 
            #(assoc {} :n n :r % :c (combinations n %)) 
            (range 1 n))))
   
(apply +
    (map count
        (map #(combinations-greater-than % 1000000) (range 1 101))))
        
(comment answer 4075)