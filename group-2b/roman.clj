; Roman Numerals

(use '[clojure.string :only (join)])
(use '[clojure.pprint :only (cl-format)])

(defn to-roman [n]
	(let [lookup {1 "I" 5 "V" 10 "X" 50 "L" 100 "C" 500 "D" 1000 "M"}
			nums [1000 500 100 50 10 5 1]]
			
			(join "" (apply concat (map-indexed
				(fn [i x] 
					(if (and (= x 4)) (str (lookup (nth nums i)) (lookup (nth nums (dec i))))
						(repeat x (lookup (nth nums i)))) 
				)
				((fn decmp [n s]
					(if (or (empty? s) (= n 0)) nil
						(concat [(quot n (first s))] (decmp (mod n (first s)) (rest s)))
					)
				) n nums)
			)))

	)

)

(defn lazy-roman [n]
	(map to-roman (range 1 n))
)

(defn from-roman [s]
	(let [lookup {1 "I" 5 "V" 10 "X" 50 "L" 100 "C" 500 "D" 1000 "M"}
			nums [1000 500 100 50 10 5 1]
			rev-lookup (apply array-map (interleave (vals lookup) (keys lookup)))]
		
		((reduce (fn [x y]
			(let [curr (rev-lookup (str y)) ]
			(if (> curr (x :last)) 
				{:val (+ curr (- (x :val) (* 2 (x :last)))) :last curr}
				{:val (+ curr (x :val)) :last curr}
			)	
			
			)
		)
		{:val 0 :last 0} s) :val)
	)
)

(prn (lazy-roman 100))
(prn (to-roman 400))
(prn (to-roman 1999))
(prn (map from-roman (lazy-roman 100)))
(prn (from-roman "CD"))
(prn (from-roman "XX"))
(prn (from-roman "XV"))
(prn (from-roman "MM"))

