(ns ui.codemirror.api.position)

(defn cursor-position [cm]
  (let [pos (.getCursor cm)
        line (.-line pos)
        ch (.-ch pos)]
    (.log js/console "pos: " pos)
    {:line line
     :col ch}))