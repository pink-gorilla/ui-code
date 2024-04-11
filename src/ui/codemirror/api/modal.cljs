(ns ui.codemirror.api.modal)

(defn focus
  [cm]
  (when cm
    (.focus cm)))

(defn blur
  [cm]
  (when cm
    (let [input (.getInputField cm)]
      (.blur input))))