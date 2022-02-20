import { BrowserRouter as Router, Route, Switch } from "react-router-dom";

import Calculator from "./sections/Calculator";
import OperationHistoryTable from "./sections/OperationHistoryTable";

const App = () => {
  return (
    <Router>
      <Switch>
        <Route exact path="/" component={Calculator} />
        <Route exact path="/history" component={OperationHistoryTable} />
      </Switch>
    </Router>
  );
}

export default App;