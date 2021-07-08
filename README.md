# ui-code [![GitHub Actions status |pink-gorilla/ui-codemirror](https://github.com/pink-gorilla/ui-code/workflows/CI/badge.svg)](https://github.com/pink-gorilla/ui-code/actions?workflow=CI)[![Clojars Project](https://img.shields.io/clojars/v/org.pinkgorilla/ui-code.svg)](https://clojars.org/org.pinkgorilla/ui-code)

[Codemirror](https://codemirror.net/) Code Editors / Viewer.

## End-Users
- this project is NOT for you! Instead go to:
- [notebook](https://github.com/pink-gorilla/notebook)

 
## Demo

```
clojure -X:goldly
```

Navigate your webbrowser to port. 
Codemirror snippets are in `running systems` / `snippet-registry`

## Use with [goldly](https://github.com/pink-gorilla/goldly)

This library provides the pinkie ui renderer [:p/codemirror id atom path]


Add this alias to your deps.edn:

```
 :goldly
  {:extra-deps {org.pinkgorilla/goldly {:mvn/version "RELEASE"}
                org.pinkgorilla/ui-code {:mvn/version "RELEASE"}}
   :exec-fn goldly-server.app/goldly-server-run!
   :exec-args {:profile "watch"
               :config {:goldly {}}}}
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