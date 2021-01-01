/// <reference types="cypress" />

context('Teams listing', () => {
  beforeEach(() => {
    cy.visit('http://localhost:8081/teams/view?name=Icehawks');
  })

  it('Teams lisitng page has a single card', () => {
  	cy.title().should('include', 'View team');
  	cy.contains('Member since');
  })

  it('Navbar is available', () => {
  	cy.contains('Home');
  	cy.contains('Roster');
  	cy.contains('Analytics');
  })
})
