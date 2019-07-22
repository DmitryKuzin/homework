import React, {Component} from 'react';
import EmployeeTable from './components/EmployeeTable';
import EmployeeForm from "./components/EmployeeForm";
import DeleteEmployeesButton from "./components/DeleteEmployeesButton";
import 'antd/dist/antd.css'
import './App.css';

class App extends Component {
  render() {
    return (
      <div>
        <div className="header">
          <h2>Homework</h2>
        </div>
        <div className="content">
          <EmployeeForm/>
          <EmployeeTable/>
          <DeleteEmployeesButton/>
        </div>
      </div>
    );
  }
}

export default App;
