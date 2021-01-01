/// <reference types="cypress" />

context('Teams listing', () => {
  beforeEach(() => {
    cy.visit('http://localhost:8081/teams/all');
  })

  it('Teams listing page has cards with the names of the teams', () => {
  	cy.title().should('include', 'View team');
  	cy.contains('Icehawks');
  	cy.contains('Kemphanen');
  })

  it('Navbar is available', () => {
  	cy.contains('Home');
  	cy.contains('Roster');
  	cy.contains('Analytics');
  })
})
