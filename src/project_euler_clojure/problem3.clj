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
  (def s (get-s n))
  (loop [k 1]
    (def y (get-y s k n))
    (def x (get-x s k))
    (def a (get-a x y))
    (def b (get-b x y))
    (println k x y a b)
    (cond 
      (no-rem y) [a b]
      (no-rem (Math/sqrt n)) [(Math/sqrt n) (Math/sqrt n)]
      (even? (int n)) [2 (/ n 2)]
      (some (partial <= n) [x y]) [n 1]
      :else (recur (inc k)))))

(defn ferma
  [n]
  (cond
    (even? (int n)) [(/ n 2) 2]
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
  [n] 
  (tree-seq
    ; branch?
    (fn [a]
      ; (println ":branch?" a)
      (not= 1 (int (apply min (ferma a)))))
    ; generate children
    (fn [a]
      ; (println ":get-children" a)
      (ferma a))
    n))

(defn solve-fn [] (
  (max (rest (trie 89755))  ; 600851475143
))

(defn solve
  []
  (println "Problem 3:" (solve-fn))
)
