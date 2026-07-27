import React from 'react';
import '../Stylesheets/mystyle.css';

function percentToDecimal(decimal) {
  return (decimal * 100).toFixed(2) + '%';
}

function calcScore(total, goal) {
  return percentToDecimal(total / goal);
}

export const CalculateScore = ({ Name, School, Total, goal }) => {
  const average = calcScore(Total, goal);

  return (
    <div className="formatstyle">
      <h1><font color="Brown">Student Details:</font></h1>
      <div className="Name">
        <b><span>Name:</span></b>
        <span>{Name}</span>
      </div>
      <div className="School">
        <b><span>School:</span></b>
        <span>{School}</span>
      </div>
      <div className="Total">
        <b><span>Total:</span></b>
        <span>{Total}</span>
        <span>Marks</span>
      </div>
      <div className="Score">
        <b><span>Score:</span></b>
        <span>{average}</span>
      </div>
    </div>
  );
};

export default CalculateScore;
