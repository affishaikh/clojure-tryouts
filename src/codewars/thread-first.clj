; A function which mimics the thread-first macro of clojure

(defn thread-first [val & forms]
      (reduce #(eval (conj (conj (rest %2) %1) (first %2))) val forms))
