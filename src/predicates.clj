(ns predicates)

(defn sum-f [f g x]
  (+ (f x) (g x)))

(defn less-than [n]
  (fn [x] (< x n)))


(defn equal-to [n]
  (fn [x] (== x n)))

(defn set->predicate [a-set]
  (fn [v] (contains? a-set v)))

(defn pred-and [pred1 pred2]
  (fn [x] (and (pred1 x) (pred2 x))))

(defn pred-or [pred1 pred2]
  (fn [x] (or (pred1 x) (pred2 x))))

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
 (= (apply str (filter (fn [c] (not (whitespace? c))) string)) ""))

(defn has-award? [book award]
  (contains? (book :awards) award))


(defn HAS-ALL-THE-AWARDS? [book awards]
  (empty? (filter (fn [a] (not (has-award? book a))) awards)))

(defn my-some [pred a-seq]
  (first (filter identity (map (fn [x] (pred x)) a-seq))))

(defn my-every? [pred a-seq]
  (= '()  (filter (fn[x] (not (identity x))) (map (fn [x] (pred x)) a-seq))))


(defn prime? [n]
  (= (filter (fn [x] (= 0 (mod n x))) (range 2 n)) '()))

