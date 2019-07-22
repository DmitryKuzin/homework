import React, {Component} from 'react';
import PropTypes from 'prop-types';
import {connect} from 'react-redux';
import {fetchEmplyeesAsync, editSalaryAsync} from '../actions';
import EditableFormTable from './EditableTable';

class EmployeeTable extends Component {
  state = {};

  componentDidMount() {
    this.props.fetchEmployees();
  }

  render() {
    const {isLoading, employees, editSalary} = this.props;
    console.log(employees);
    return !isLoading && (<EditableFormTable employees={employees} editSalary={editSalary}/>)
  }
}

const mapStateToProps = state => state;

const mapDispatchToProps = (dispatch) => {
  return {
    fetchEmployees: () => dispatch(
      fetchEmplyeesAsync(),
    ),
    editSalary: (employeeId, editingSum) => dispatch(
      editSalaryAsync(employeeId, editingSum),
    )
  };
};

EmployeeTable.propTypes = {
  fetchEmployees: PropTypes.func,
  editSalary: PropTypes.func,
  isLoading: PropTypes.bool,
  employees: PropTypes.object,
};

export default connect(mapStateToProps, mapDispatchToProps)(EmployeeTable);
