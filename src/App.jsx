import { Routes, Route } from "react-router-dom";

import Login from "./pages/Login";
import Register from "./pages/Register";
import Dashboard from "./pages/Dashboard";
import CreateGroup from "./pages/CreateGroup";
import ViewGroups from "./pages/ViewGroups";
import AddMember from "./pages/AddMember";
import ViewMembers from "./pages/ViewMembers";
import AddExpense from "./pages/AddExpense";
import ViewExpenses from "./pages/ViewExpenses";
import Settlement from "./pages/Settlement";

function App() {

    return (
        <Routes>
            <Route
                path="/"
                element={<Login />}
            />
            <Route
                path="/register"
                element={<Register />}
            />
            <Route
    path="/dashboard"
    element={<Dashboard />}
        />
        <Route 
        path="/create-group"
        element={<CreateGroup />}
        />
        <Route
    path="/view-groups"
    element={<ViewGroups />}
/>
<Route
    path="/add-member/:groupId"
    element={<AddMember />}
/>

        <Route
    path="/view-members/:groupId"
    element={<ViewMembers />}
/>
                  <Route
    path="/add-expense/:groupId"
    element={<AddExpense />}
/>

            <Route
    path="/view-expenses/:groupId"
    element={<ViewExpenses />}
/>

<Route
    path="/settlement/:groupId"
    element={<Settlement />}
/>
        </Routes>

        
    );

}

export default App;