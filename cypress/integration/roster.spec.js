/// <reference types="cypress" />

context('Teams listing', () => {
  beforeEach(() => {
    cy.visit('http://localhost:8081/teams/roster');
  })

  it('Teams roster page has the correct headers', () => {
  	cy.title().should('include', 'Team Roster');
  	cy.contains('Name');
  	cy.contains('Date of birth');
    cy.contains('Height');
    cy.contains('Weight');
    cy.contains('Position');
    cy.contains('Shoots');
    cy.contains('Catches');
  })

  it('Navbar is available', () => {
  	cy.contains('Home');
  	cy.contains('Roster');
  	cy.contains('Analytics');
  })
})
