(ns may-2012.core-test
  (:use clojure.test
        may-2012.core))

(deftest units-test
  (let [roman-units ["i" "ii" "iii" "iv" "v"
                "vi" "vii" "viii" "ix" "x"]]
    (is (= (map roman [1 2 3 4 5 6 7 8 9 10]) roman-units))))

(deftest tens-test
  (let [roman-tens ["x" "xx" "xxx" "xl" "l" "lx"
                    "lxx" "lxxx" "xc" "c"]]
    (is (= (map roman
                (map #(* 10 %) (range 1 11)))
           roman-tens))))

(deftest tell-me-various-numbers-in-roman-numerals
  (are [x y] (= x (roman y))
       "xiv" 14
       "xxx" 30
       "xlix" 49
       ))

(deftest tell-me-numbers-in-hundreds-in-roman-numerals
  (are [x y] (= x (roman y))
       "cxx" 120
       "cxxiv" 124
       "dix" 509
       "m" 1000
       ))

(deftest tell-me-really-big-numbers-in-roman-numerals
  (are [x y] (= x (roman y))
       "mcmxliv" 1944
       "mmmmcmxcix" 4999
       "V" 5000
       "?cccxxi" 10321))

(deftest i-want-28-roman-numerals-after-36
  (is (= (->> romans-seq (drop 36) (take 28))
         (map roman (range 37 65)))))
