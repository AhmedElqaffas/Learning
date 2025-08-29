# RDF + Langchain
Experimenting with querying RDF graphs using Langchain.

## What I did

- Used [GraphDB](https://graphdb.ontotext.com/) as a triple store, 
to create triplets using SPARQL and visualize them.
- Exported the triplets in `Turtle` file format.
- Used Langchain [RDFLib](https://python.langchain.com/docs/integrations/graphs/rdflib_sparql/)
to perform query on the `.ttl` file based on natural language questions.
- Tried `RDFS` and `OWL` rulesets.
    - `RDFS` -> `rdfs_graph.ipynb` and `rdfs_graph.ttl`
    - `OWL` ->  `owl_graph.ipynb` and `owl_graph.ttl`
