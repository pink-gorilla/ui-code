# ui-codemirror [![GitHub Actions status |pink-gorilla/ui-codemirror](https://github.com/pink-gorilla/ui-codemirror/workflows/CI/badge.svg)](https://github.com/pink-gorilla/ui-codemirror/actions?workflow=CI)[![Clojars Project](https://img.shields.io/clojars/v/org.pinkgorilla/ui-codemirror.svg)](https://clojars.org/org.pinkgorilla/ui-coemirror)

Use [cdemirror](https://codemirror.net/) in goldly.

## End-Users
- this project is NOT for you! Instead go to:
- [notebook](https://github.com/pink-gorilla/notebook)
- [notebook (bundel)](https://github.com/pink-gorilla/notebook-bundel)
- [goldly](https://github.com/pink-gorilla/goldly)
- [goldly bundel](https://github.com/pink-gorilla/goldly-bundel)


## Demo

```
clojure -X:goldly
```

Navigate your webbrowser to port. 
Quil snippes are in `running systems` / `snippet-registry`

## Why ui-codemirror?

- Codemirror requires a lot of customization, so this needs to be done somewhere
- this is especially true for startup bootstrapping (css with themes, js global init)
- goldly needs to edit snippets
- notebook needs to edit code (inside a notebook)
- in goldly apps you might have a special usecase

## Use outside of goldly and webly

- We use on goldly and webly to manage css and for snippet examples.
- You can create a custom clojurescript project with shadow-cljs 
  and ignore `src/goldly`.