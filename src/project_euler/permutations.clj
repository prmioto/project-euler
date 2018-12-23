(ns project-euler.permutations
  (:gen-class))

(comment
(defn join [s1 s2]
  (distinct (into s1 s2)))
)
  
(defn join [s1 s2]
  (distinct (concat s1 s2)))

(defn add-to-begin [coll el]
    (conj (seq coll) el))
    
(defn add-to-end [coll el]
    (join coll (list el)))
  
(defn rotate-left [coll n]
   (join
     (take-last (- (count coll) n) coll)
     (take n coll)))

(defn rotate-all [coll]
  (reverse
    (reduce
      #(conj %1 (rotate-left coll %2))
      (conj '() coll)
      (range 1 (count coll)))))

(defn conj-to-all [seq-list el]
 (comment (println "conj-to-all" seq-list el))
  (map 
    #(add-to-begin % el)
    seq-list))

(defn permutate [coll]
  (if (<= (count coll) 2)
    (rotate-all coll)
    (mapcat
      #(conj-to-all 
         (permutate (rest %)) 
         (first %))
      (rotate-all coll))))
        
(defn anagram [s]
  (distinct 
    (map #(apply str %) (permutate (seq s)))))

