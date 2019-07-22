import React, {Component} from 'react';
import PropTypes from 'prop-types';
import Button from 'antd/lib/button';
import {connect} from 'react-redux';
import {deleteEmployeesAsync} from '../actions';

class DeleteEmployeesButton extends Component {
  render() {
    return (
      <Button className="fire-button" type="primary" onClick={this.props.deleteEmployees}>Delete all!</Button>
    )
  }
}

const mapStateToProps = state => state;

const mapDispatchToProps = (dispatch) => {
  return {
    deleteEmployees: () => dispatch(
      deleteEmployeesAsync(),
    ),
  };
};

DeleteEmployeesButton.propTypes = {
  deleteEmployees: PropTypes.func,
};

export default connect(mapStateToProps, mapDispatchToProps)(DeleteEmployeesButton);
