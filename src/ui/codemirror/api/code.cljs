(ns ui.codemirror.api.code)

(defn set-code [cm code]
  (.setValue cm code))

(defn get-code [cm]
  (.getValue cm))

