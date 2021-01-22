/// <reference types="cypress" />

context('Players', () => {
  beforeEach(() => {
    cy.visit('http://localhost:8081/players/view');
  })

  it('Players profile is displayed', () => {
  	cy.title().should('include', 'Player profile');
  	cy.contains('Height');
    cy.contains('Weight');
    cy.contains('Position');
    cy.contains('Shoots');
  })

  it('Navbar is available', () => {
  	cy.contains('Home');
  	cy.contains('Roster');
  	cy.contains('Analytics');
  })
})
