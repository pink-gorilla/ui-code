# ui-codemirror [![GitHub Actions status |pink-gorilla/ui-codemirrormirror](https://github.com/pink-gorilla/ui-codemirror/workflows/CI/badge.svg)](https://github.com/pink-gorilla/ui-codemirror/actions?workflow=CI)[![Clojars Project](https://img.shields.io/clojars/v/org.pinkgorilla/ui-codemirror.svg)](https://clojars.org/org.pinkgorilla/ui-codemirror)

[Codemirror](https://codemirror.net/) Code Editors / Viewer.

## End-Users
- this project is NOT for you! Instead go to:
- [goldly notebook](https://github.com/pink-gorilla/goldly)

## Why ui-codemirror?

- Codemirror requires a lot of customization, so this needs to be done somewhere
- this is especially true for startup bootstrapping (css with themes, js global init)
- a clojure editor is handy to edit code snippets or entire code namespaces.
 

## Demo

```
cd demo
clojure -X:webly:npm-install
clojure -X:webly:compile
clojure -X:webly:run
```

Navigate your webbrowser to port 8080. 
