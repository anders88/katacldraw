(ns cldraw.core)

(def seeded  #{
	{:name "Paris" :country "France" :group 1}
	{:name "Schalke" :country "Germany" :group 2}
	{:name "Malaga" :country "Spain" :group 3}
	{:name "Borrosia" :country "Germany" :group 4}
	{:name "Juventus" :country "Italy" :group 5}
	{:name "Bayern" :country "Germany" :group 6}
	{:name "Barcelona" :country "Spain" :group 7}
	{:name "Manchester" :country "England" :group 8}
})

(def unseeded #{
	{:name "Porto" :country "Portogal" :group 1}
	{:name "Arsenal" :country "England" :group 2}
	{:name "Milan" :country "Italy" :group 3}
	{:name "Madrid" :country "Spain" :group 4}
	{:name "Donsesk" :country "Ukrainia" :group 5}
	{:name "Valencia" :country "Spain" :group 6}
	{:name "Celtic" :country "Scotland" :group 7}
	{:name "Galatasaray" :country "Turkey" :group 8}
})

(defn legal? [a b] 
	(not (or (= (a :country) (b :country)) (= (a :group) (b :group))))
	)

(def teller (ref 0))


(defn count-combos [left-a left-b]
	(if (empty? left-a) 1
		(let [a (first left-a)] (reduce + (for [b left-b] (if (legal? a b) (count-combos (rest left-a) (disj left-b b)) 0))))
	)
)

(defn -main [& m]
	(println (count-combos seeded unseeded))
	)
