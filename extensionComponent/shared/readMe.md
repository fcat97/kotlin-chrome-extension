#### Shared Module

This module consists of shared logic for backend and frontend.

##### Project Structure
This module have multiple source sets, i.e:

- `commonMain`: common for all targets.
- `jsMain`: along with commonMain, some specific code for `js` targets.
- `wasmMain`: along with commonMain, some specific code for `wasm` targets.