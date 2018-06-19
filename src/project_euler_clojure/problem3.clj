; https://projecteuler.net/problem=2
(ns project-euler-clojure.problem3)

(defn get-a [x y] (+ x y))
(defn get-b [x y] (- x y))
(defn get-s [n] (Math/ceil (Math/sqrt n)))
(defn get-y [s k n] (Math/sqrt (- (Math/pow (+ s k) 2) n)))
(defn get-x [s k] (+ s k))
(defn no-rem [y] (= 0.0 (rem y 1)))

(defn get-multipliers
  [n]
  (if (1 n) [n, 1])
  (def s (get-s n))
  (loop [k 1]
    (def y (get-y s k n))
    (def x (get-x s k))
    (def a (get-a x y))
    (def b (get-b x y))
    (println k x y a b)
    (if (no-rem y)
      [a b]
      (recur (inc k)))))

(defn trie 
  [n] 
  (tree-seq
    ; branch?
    (fn [a]
     ;(println ":branch?" a)
     (and (not= 1 (int a))
          (not= 1 (int (apply min (get-multipliers a)))))
     )
    ; generate children
    (fn [a]
     ;(println ":get-children" a)
     (if (not= 1 (int a))
      (get-multipliers a))
     )
     n))

(defn solve-fn [] (
  (max (rest (trie 89755))
))

(defn solve
  []
  (println "Problem 3:" (solve-fn))
)
