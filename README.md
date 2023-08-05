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
clojure -X:goldly-build :profile '"npm-install"'
clojure -X:goldly-build :profile '"compile2"'
clojure -X:goldly-run
```

Navigate your webbrowser to port 8080. 
