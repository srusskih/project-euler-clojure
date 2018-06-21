; https://projecteuler.net/problem=3
(ns project-euler-clojure.problem3)

(defn no-rem [y] (= 0.0 (rem y 1)))

(defn ferma
  [n]
  (cond
    (even? (bigint n)) [(/ n 2) 2]
    :else
      (loop [k 0]
        (def a (+ (Math/ceil (Math/sqrt n)) k))
        (def b2 (- (* a a) n))
        (def b (Math/sqrt b2))
        ; (println k ":" a b2 b)
        (if (no-rem b)
         [(+ b a) (- a b)]
         (recur (inc k))))))

(defn trie 
  "Build a multipliers tree.
  Node is a factors (multipliers) of a number.
  Leaf is a prime factor.
  "
  [n] 
  (tree-seq
    ; branch?
    (fn [a]
      ; (println ":branch?" a)
      (not= 1.0 (apply min a)))
    ; generate children
    (fn [a]
      ; (println ":get-children" a)
      (map ferma a))
    n))

(defn leafs
  "Collect prime factors from a multipliers tree."
  [trie-seq]
  (filter (fn [[a b]] (= 1.0 (min a b))) 
          trie-seq))

(defn solve-fn 
  "Find maximum prime factor of 600851475143."
  [] 
  (int (apply max 
           (map first
                (leafs (trie (ferma 600851475143N))))) ))

(defn solve
  []
  (println "Problem 3:" (solve-fn)))
