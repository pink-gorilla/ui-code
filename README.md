# ui-code [![GitHub Actions status |pink-gorilla/ui-codemirror](https://github.com/pink-gorilla/ui-code/workflows/CI/badge.svg)](https://github.com/pink-gorilla/ui-code/actions?workflow=CI)[![Clojars Project](https://img.shields.io/clojars/v/org.pinkgorilla/ui-code.svg)](https://clojars.org/org.pinkgorilla/ui-code)

Code Editors + Viewers:
- [Codemirror](https://codemirror.net/) for editing.
- [Highlight.js]()

## End-Users
- this project is NOT for you! Instead go to:
- [goldly](https://github.com/pink-gorilla/goldly)
- [notebook](https://github.com/pink-gorilla/notebook)

 
## Demo

```
clojure -X:goldly
```

Navigate your webbrowser to port. 
Codemirror snippets are in `running systems` / `snippet-registry`

## Use with [goldly](https://github.com/pink-gorilla/goldly)

This library provides the pinkie ui renderer [:p/codemirror id atom path]

You can add either just the ui renderer [ui.code.goldly.core], 
or can also add the snippets [ui.code.goldly.snippets].

Add this alias to your deps.edn:

```
 :goldly
  {:extra-deps {org.pinkgorilla/goldly {:mvn/version "0.2.39"}
                org.pinkgorilla/ui-code {:mvn/version "0.0.3"}}
   :exec-fn goldly-server.app/goldly-server-run!
   :exec-args {:profile "watch"
               :config {:goldly {:extensions [[ui.code.goldly.core]
                                              [ui.code.goldly.snippets]
                                              ]}}}}
```



## Why ui-code?

- Codemirror requires a lot of customization, so this needs to be done somewhere
- this is especially true for startup bootstrapping (css with themes, js global init)
- goldly needs to edit snippets
- notebook needs to edit code (inside a notebook)
- in goldly apps you might have a special usecase

## Use outside of goldly and webly

- We use on goldly and webly to manage css and for snippet examples.
- You can create a custom clojurescript project with shadow-cljs 
  and ignore `src/goldly`.