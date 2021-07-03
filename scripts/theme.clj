
;; babashka script to generate css config.
(defn add-themes [m theme-base themes]
  (let [theme-link (fn [theme]
                     (format theme-base theme))
        add-theme (fn [acc theme]
                    ;(println "adding:" theme)
                    (assoc acc theme [(theme-link theme)]))]
    (reduce add-theme m themes)))

(def highlight-themes-main
  ["default"
   "github"
   "zenburn"])

(def highlight-themes
  ["default"
   "zenburn"
   "vs2015"
   "github-gist"
   "github"
   "googlecode"
   "codepen-embed"
   "xcode"
   "vs"
   "a11y-dark"
   "atelier-seaside-dark"
   "gruvbox-light"
   "purebasic"
   "a11y-light"
   "atelier-seaside-light"
   "hopscotch"
   "qtcreator_dark"
   "agate"
   "atelier-sulphurpool-dark"
   "hybrid"
   "qtcreator_light"
   "androidstudio"
   "atelier-sulphurpool-light"
   "idea"
   "railscasts"
   "an-old-hope"
   "atom-one-dark"
   "ir-black"
   "rainbow"
   "arduino-light"
   "atom-one-dark-reasonable"
   "isbl-editor-dark"
   "routeros"
   "arta"
   "atom-one-light"
   "isbl-editor-light"
   "school-book"
   "ascetic"
   "brown-paper"
   "kimbie.dark"
   "shades-of-purple"
   "atelier-cave-dark"
   "kimbie.light"
   "solarized-dark"
   "atelier-cave-light"
   "color-brewer"
   "lightfair"
   "solarized-light"
   "atelier-dune-dark"
   "darcula"
   "lioshi"
   "srcery"
   "atelier-dune-light"
   "dark"
   "magula"
   "sunburst"
   "atelier-estuary-dark"
   "mono-blue"
   "tomorrow"
   "atelier-estuary-light"
   "docco"
   "monokai"
   "tomorrow-night-blue"
   "atelier-forest-dark"
   "dracula"
   "monokai-sublime"
   "tomorrow-night-bright"
   "atelier-forest-light"
   "far"
   "night-owl"
   "tomorrow-night"
   "atelier-heath-dark"
   "foundation"
   "nnfx"
   "tomorrow-night-eighties"
   "atelier-heath-light"
   "nnfx-dark"
   "atelier-lakeside-dark"
   "nord"
   "atelier-lakeside-light"
   "gml"
   "obsidian"
   "atelier-plateau-dark"
   "ocean"
   "xt256"
   "atelier-plateau-light"
   "gradient-dark"
   "paraiso-dark"
   "atelier-savanna-dark"
   "grayscale"
   "paraiso-light"
   "atelier-savanna-light"
   "gruvbox-dark"
   "pojoaque"])



(println (pr-str (add-themes
                  {}
                  "highlight.js/styles/%s.css"
                  highlight-themes)))


(def fonts-aggrid
  ["Alpine"
   "Balham"
   "Classic"
   "Material"])

(def codemirror-themes
  ["default" "3024-day" "3024-night" "abcdef" "ambiance" "ayu-dark" "ayu-mirage"
   "base16-dark" "base16-light" "bespin" "blackboard" "cobalt" "colorforth"
   "darcula" "dracula" "duotone-dark" "duotone-light" "eclipse" "elegant"
   "erlang-dark" "gruvbox-dark" "hopscotch" "icecoder" "idea" "isotope"
   "lesser-dark" "liquibyte" "lucario" "material" "material-darker"
   "material-palenight" "material-ocean" "mbo" "mdn-like" "midnight" "monokai"
   "moxer" "neat" "neo" "night" "nord" "oceanic-next" "panda-syntax"
   "paraiso-dark" "paraiso-light" "pastel-on-dark" "railscasts" "rubyblue"
   "seti" "shadowfox" "solarized dark" "solarized light" "the-matrix"
   "tomorrow-night-bright" "tomorrow-night-eighties" "ttcn" "twilight"
   "vibrant-ink" "xq-dark" "xq-light" "yeti" "yonce" "zenburn"])


(println (pr-str (add-themes
 {true ["codemirror/lib/codemirror.css"]}
 "codemirror/theme/%s.css"
 codemirror-themes)))