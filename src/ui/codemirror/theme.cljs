(ns ui.codemirror.theme)

;; styles for theme

(defn style-codemirror-inline []
  ; Set height, width, borders, and global font properties here
  ; height: 200px;
  ; height: auto;    auto = adjust height to fit content 
  ; height: 100%
  [:style ".my-codemirror > .CodeMirror { 
              font-family: monospace;
              height: auto;
            }"])

(defn style-codemirror-fullscreen []
  ; height: auto; "400px" "100%"  height: auto;
  [:style ".my-codemirror > .CodeMirror { 
              font-family: monospace;
              height: 100% ;
            }"])
